package cn.yunlai.cjds.base;



import static com.sun.btrace.BTraceUtils.println;
import static com.sun.btrace.BTraceUtils.sizeof;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.BTraceUtils.Strings;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Duration;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;
import com.sun.btrace.annotations.Return;

/**
 * Hello world!
 *
 */
@BTrace
public class Monitor {
    /**
     * 跟踪执行时间
     * 
     */
    @OnMethod(clazz = "cn.yunlai.cjds.user.handler.account.WechatPublicHander", method = "baseCreateAccount", location = @Location(Kind.RETURN))
    public static void func1(@ProbeClassName String clasName, @ProbeMethodName String methodName, @Duration long duration) {
        BTraceUtils.println(clasName + "." + methodName + "=>" + duration / 1000000 + " ms");
    }

    /**
     * 跟踪返回结果
     */
    @OnMethod(clazz = "cn.yunlai.cjds.user.handler.account.WechatPublicHander", method = "recordSubscribeStatus", location = @Location(Kind.RETURN))
    public static void func4(@Return Object obj) {
        println(Strings.concat("size", Strings.str(sizeof(obj))));
    }
}
