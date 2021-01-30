package com.hiwork.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import com.hiwork.domain.Worker;
import com.hiwork.service.WorkerService;

@Component
public class AutoLoginInterceptor implements HandlerInterceptor {
  WorkerService workerService;

  public AutoLoginInterceptor(WorkerService workerService) {
    this.workerService = workerService;
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    if (request.getSession().getAttribute("loginUser") == null) {
      Worker worker = workerService.get("aaa@test.com", "1111");
      request.getSession().setAttribute("loginUser", worker);
    }
    return true;
  }
}
