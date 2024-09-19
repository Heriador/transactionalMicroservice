package com.Emazon.transactionMicroservice.infrastructure.configuration.security.filter;

import com.Emazon.transactionMicroservice.infrastructure.configuration.security.CustomUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import static com.Emazon.transactionMicroservice.infrastructure.configuration.util.AuthenticationConstants.*;


@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {


    private final CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader(AUTHORIZATION_HEADER);


        if(authHeader == null || !authHeader.startsWith(BEARER_PREFIX)) {
            filterChain.doFilter(request, response);
            return;
        }

        try{

            String jwt = authHeader.split(TOKEN_SEPARATOR)[JWT_INDEX];

            UserDetails user = userDetailsService.loadUserByUsername(jwt);



            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user,jwt, user.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authToken);


        }
        catch (Exception e){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, INVALID_TOKEN_MESSAGE);
            return;
        }

        filterChain.doFilter(request, response);

    }
}
