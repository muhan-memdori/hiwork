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
    System.out.println("AutoLoginInterceptor 실행!");

    if (request.getSession().getAttribute("loginUser") == null) {
      // 개발하는 동안 로그인을 자동으로 처리하기 위해
      // 임의의 사용자로 로그인 한다.
      //Worker worker = workerService.get("aaa@test.com", "1111");
      Worker loginUser = new Worker().setNo(1L).setEmail("aaa@test.com").setName("김태희");
      request.getSession().setAttribute("loginUser", loginUser);
    }
    return true;
  }
}
