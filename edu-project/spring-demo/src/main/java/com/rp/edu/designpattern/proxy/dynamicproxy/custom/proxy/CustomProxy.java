package com.rp.edu.designpattern.proxy.dynamicproxy.custom.proxy;

import com.rp.edu.designpattern.proxy.dynamicproxy.custom.client.ClientProxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * CGLib 和 JDK 动态代理对比：
 * （1）JDK 动态代理实现了被代理对象的接口，CGLib 代理继承了被代理对象。
 * （2）JDK 动态代理和 CGLib 代理都在运行期生成字节码，JDK 动态代理直接写 Class 字节码，CGLib
 *      代理使用 ASM 框架写 Class 字节码，CGlib 代理实现更复杂，生成代理类比 JDK 动态代理效率低。
 * （3）JDK 动态代理调用代理方法是通过反射机制调用的，CGLib 代理是通过 FastClass 机制直接调
 * 用方法的，CGLib 代理的执行效率更高。
 */
public class CustomProxy {
    private static final String ln = "\r\n";

    public static Object newProxyInstance(CustomClassLoader loader, Class<?>[] interfaces, CustomInvocationHandler h){

        try {

            // 1、生成源文件$Proxy0.java文件（字符串拼接）
            String str = generateStr(interfaces);
            System.out.println(str);
            // 2、将$Proxy0.java源文件输出到磁盘

            String path = CustomProxy.class.getResource("").getPath();
            File file = new File(path + "$Proxy0.java");
            FileWriter fw = new FileWriter(file);
            fw.write(str);
            fw.flush();
            fw.close();


            // 3、将$Proxy0.java文件编译成$Proxy0.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manage = compiler.getStandardFileManager(null,null,null);
            Iterable iterable = manage.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = compiler.getTask(null,manage,null,null,null, iterable);
            task.call();
            manage.close();

            // 4、把编译生成的.class 文件加载到 JVM 中
            Class proxyClass = loader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(CustomInvocationHandler.class);
            /* 删除文件 */
            file.delete();

            // 5、返回字节码重组以后的新的代理对象
            return c.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateStr(Class<?>[] interfaces) {
        StringBuilder sb = new StringBuilder();
        sb.append("package com.rp.edu.designpattern.proxy.dynamicproxy.custom.proxy;" + ln);
        sb.append("import com.rp.edu.designpattern.proxy.dynamicproxy.custom.client.IPeople;" + ln);
        sb.append("import java.lang.reflect.*;" + ln);
        sb.append("public class $Proxy0 implements "+ interfaces[0].getName() + " {" + ln);
            sb.append("CustomInvocationHandler h;" +ln);
            sb.append("public $Proxy0(CustomInvocationHandler h) {" +ln);
                sb.append("this.h = h;" + ln);
            sb.append("}" + ln);

            for (Method m : interfaces[0].getMethods()) {
                Class[] params = m.getParameterTypes();
                StringBuilder paramNames = new StringBuilder();
                StringBuilder paramValues = new StringBuilder();
                StringBuilder paramClasses = new StringBuilder();
                if (params.length > 0) {
                    for (int i = 0, j = params.length; i < j; i++) {
                        Class<?> clazz = params[i];
                        String paramType = clazz.getName();
                        String value = toLowerFirstCase(clazz.getSimpleName());
                        paramNames.append(paramType + " " + value);
                        paramValues.append(value);
                        paramClasses.append(paramType + ".class");
                        /* 若参数为多个 */
                        if (i < j-1) {
                            paramNames.append(", ");
                            paramValues.append(", ");
                            paramClasses.append(", ");
                        }
                    }
                }

                sb.append("@Override" + ln);
                sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "(" + paramNames.toString() + ") {" + ln);
                    sb.append("try{" + ln);

                        sb.append("Method method = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\", new Class[]{" +
                                paramClasses.toString() + "});" + ln);

                        sb.append("this.h.invoke(this, method, new Object[]{" + paramValues.toString() + "});" + ln);
                        sb.append("return;" + ln);

                    sb.append("} catch (RuntimeException | Error var2){" + ln);
                        sb.append("throw var2;" + ln);
                    sb.append("} catch (Throwable var3) {" + ln);
                        sb.append("throw new UndeclaredThrowableException(var3);" + ln);
                    sb.append("}" + ln);
                sb.append("}" + ln);
            }
        sb.append("}" + ln);

        return sb.toString();
    }

    private static Map<Class,Class> mappings = new HashMap<Class, Class>();
    static {
        mappings.put(int.class,Integer.class);
    }
    private static String getReturnEmptyCode(Class<?> returnClass){
        if(mappings.containsKey(returnClass)){
            return "return 0;";
        }else if(returnClass == void.class){
            return "";
        }else {
            return "return null;";
        }
    }

    /**
    "this.h.invoke(this, method, new Object[]{" + paramValues + "})", m.getReturnType()
     */
    private static String getCaseCode(String code, Class<?> returnClass){
        if(mappings.containsKey(returnClass)){
            return "((" + mappings.get(returnClass).getName() + ")" + code + ")." + returnClass.getSimpleName() +
                    "Value()";
        }
        return code;
    }

    private static boolean hasReturnValue(Class<?> clazz) {
        return clazz != void.class;
    }

    /**
     * 首字母转小写
     * @param src
     * @return
     */
    private static String toLowerFirstCase(String src){
        char [] chars = src.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

}
