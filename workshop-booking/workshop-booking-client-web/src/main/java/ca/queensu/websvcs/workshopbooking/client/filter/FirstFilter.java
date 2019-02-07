package ca.queensu.websvcs.workshopbooking.client.filter;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstFilter implements Filter {

    protected FilterConfig config;
    protected String filterName;

    /** {@inheritDoc} */
    @Override
    public void doFilter(ServletRequest req,
            ServletResponse res,
            FilterChain chain)
            throws ServletException, IOException {

        System.out.println("### FirstFilter running");
        chain.doFilter(req, res);
    }

    /** {@inheritDoc} */
    @Override
    public void init(FilterConfig config)
            throws ServletException {
        this.config = config;
        this.filterName = config.getFilterName();
    }


    @Override
    public void destroy() {
    }
}
