package com.ly.jetty.server.run;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;

import com.ly.jetty.service.JettyCustomerServer;

public class JettyServerStart {
	public static void main(String[] args) {

//        JettyCustomerServer server = new JettyCustomerServer(
//                "./jetty/etc/jetty.xml", "/testcontext");
//        server.startserver();
		
		String jetty_home = "jettytest";//这个就是你的项目发布时候的名字
		try {
			Server server = new Server();
			Connector connector = new SelectChannelConnector();
			connector.setPort(9999);
			server.setConnectors(new Connector[] { connector });
			WebAppContext webapp = new WebAppContext();
			webapp.setContextPath("/"+jetty_home);//上下文路径 比如说/jettytest
			webapp.setResourceBase("./webroot");//你的资源文件所在的路径 一般都在这下面
			webapp.setDefaultsDescriptor("./jetty/etc/webdefault.xml");
			server.setHandler(webapp);
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
