package com.xrest.nchl.core;

import com.xrest.nchl.model.Customer;
import com.xrest.nchl.repository.CustomerRepository;
import com.xrest.nchl.service.CustomerService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Authorize extends BasicAuthenticationFilter {


    private final CustomerRepository customerRepository;
    public Authorize(AuthenticationManager authenticationManager, CustomerRepository customerRepository) {
        super(authenticationManager);
        this.customerRepository = customerRepository;
    }
    @Override
   public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            String header = request.getHeader(JwtUtils.header);
            if (header.contains(JwtUtils.tokenType)) {
                String token = header.substring(7);
                String username = JwtUtils.decode(token);
                Customer customer =  customerRepository.getCustomerByUsername(username);
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(customer.getUsername(), null, customer.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                chain.doFilter(request,response);
            }
        }catch (Exception ex) {
            response.setStatus(401);
            response.getWriter().write("Unauthorized Access");
        }

    }
}
