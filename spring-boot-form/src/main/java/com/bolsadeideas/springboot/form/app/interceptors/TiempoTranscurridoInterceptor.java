package com.bolsadeideas.springboot.form.app.interceptors;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("tiempoTranscurridoInterceptor")
public class TiempoTranscurridoInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(TiempoTranscurridoInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// para hacer que el metodo post no entre en los interceptores
		if (request.getMethod().equalsIgnoreCase("post")) {
			return true;
		}

		// Para invocar el nombre del metodo que interceptamos
		if (handler instanceof HandlerMethod) {
			HandlerMethod metodo = (HandlerMethod) handler;
			logger.info("Es un método del controlador: " + metodo.getMethod().getName());
		}

		logger.info("TiempoTranscurridoInterceptor: preHandle() entrando ...");
		logger.info("Interceptando: " + handler);
		long tiempoInicio = System.currentTimeMillis();
		request.setAttribute("tiempoInicio", tiempoInicio);

		Random random = new Random();
		Integer demora = random.nextInt(500);
		Thread.sleep(demora);

		// Para en caso de que falle, nos envíe a otra vista
		// Sólo es un ejemplo
		// response.sendRedirect(request.getContextPath().concat("/login"));

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		// para hacer que el metodo post no entre en los interceptores
		if (!request.getMethod().equalsIgnoreCase("post")) {

			long tiempoFin = System.currentTimeMillis();
			long tiempoInicio = (Long) request.getAttribute("tiempoInicio");
			long tiempoTranscurrido = tiempoFin - tiempoInicio;

			if (handler instanceof HandlerMethod && modelAndView != null) {
				modelAndView.addObject("tiempoTranscurrido", tiempoTranscurrido);
			}
			logger.info("Tiempo transcurrido: " + tiempoTranscurrido + " milisegundos");
			logger.info("TiempoTranscurridoInterceptor: postHandle() saliendo ...");

			HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		}
	}

}
