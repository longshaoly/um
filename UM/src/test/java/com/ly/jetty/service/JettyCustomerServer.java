package com.ly.jetty.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.xml.XmlConfiguration;
import org.xml.sax.SAXParseException;


public class JettyCustomerServer extends Server {

	private String xmlconfigpath;
    private String contextpath;
    private String warpath;
    private String resourcebase = "./webroot";
    private String webxmlpath = "./webroot/WEB-INF/web.xml";

    
    
    
    
    
    

    public JettyCustomerServer(String xmlconfigpath, String contextpath) {
		super();
		this.xmlconfigpath = xmlconfigpath;
		this.contextpath = contextpath;
	}

    
    
    
	private void readxmlconfig() {
        try {
            XmlConfiguration configuration = new XmlConfiguration(
                    new FileInputStream(this.xmlconfigpath));
            configuration.configure(this);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (SAXParseException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void applyhandle(boolean wardeployflag) {
        ContextHandlerCollection handler = new ContextHandlerCollection();
        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath(contextpath);
        webapp.setDefaultsDescriptor("./jetty/etc/webdefault.xml");
        if (!wardeployflag) {
            webapp.setResourceBase(resourcebase);
            webapp.setDescriptor(webxmlpath);
        } else {
            webapp.setWar(warpath);
        }
        handler.addHandler(webapp);
        super.setHandler(handler);
    }

    public void startserver() {
        try {
            super.start();
            System.out.println("current thread:"
                    + super.getThreadPool().getThreads() + "| idle thread:"
                    + super.getThreadPool().getIdleThreads());
            super.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getxmlconfigpath() {
        return xmlconfigpath;
    }

    public void setxmlconfigpath(String xmlconfigpath) {
        this.xmlconfigpath = xmlconfigpath;
    }

    public String getcontextpath() {
        return contextpath;
    }

    public void setcontextpath(String contextpath) {
        this.contextpath = contextpath;
    }

    public String getresourcebase() {
        return resourcebase;
    }

    public void setresourcebase(String resourcebase) {
        this.resourcebase = resourcebase;
    }

    public String getwebxmlpath() {
        return webxmlpath;
    }

    public void setwebxmlpath(String webxmlpath) {
        this.webxmlpath = webxmlpath;
    }

    public String getwarpath() {
        return warpath;
    }

    public void setwarpath(String warpath) {
        this.warpath = warpath;
    }
}
