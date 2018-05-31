package com.hywin.demo.controller;

import com.hywin.demo.base.BaseControllerTest;
import com.hywin.demo.service.user.UserService;
import com.hywin.demo.user.pojo.User;
import com.hywin.framework.pojo.ResponseEntity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.annotation.Rollback;


import java.util.LinkedList;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * 
 */
public class UserControllerTest extends BaseControllerTest {

	@Mock
	private UserService userService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		super.setUp();
	}


	@Test
	public void testAdd() {
		Long id = 1L;
		String name = "test";

		User user = new User();
		user.setId(id);
		user.setName(name);

		when(userService.getNameById(id)).thenReturn(new ResponseEntity("test"));

		ResponseEntity retDa = userService.getNameById(id);
		//assertEquals("test1", retDa.getData());

		//verify(userService).getNameById(id);
		// 模拟LinkedList 的一个对象
		LinkedList mockedList = mock(LinkedList.class);
		System.out.println(mockedList.get(999));
		when(mockedList.get(0)).thenReturn("first");
		System.out.println(mockedList.get(0));

		// anyInt()匹配任何int参数，这意味着参数为任意值，其返回值均是element
		when(mockedList.get(anyInt())).thenReturn("element");

// 此时打印是element
		System.out.println(mockedList.get(999));
		System.out.println(mockedList.get(909));

		// 调用add一次
		mockedList.add("once");
		verify(mockedList).add("once");
//		verify(mockedList, times(1)).add("once");
	}

	@Test
	@Rollback(false)
	public void getUserName() {
		try {
//			MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
//					.get("/user/getUserName");
//
//			requestBuilder.param("id", "5");
//			requestBuilder.characterEncoding("UTF-8");

//			MvcResult result = mockMvc.perform(get("/user/getUserName/{id}", 5)).andReturn();
//			mockMvc.perform(get("/user/getUserName/{id}", 5))
//			.andDo(print())
//					.andExpect(status().isOk())
//					.andExpect(jsonPath("code").value("000000"));

			mockMvc.perform(get("/user/getUserList?userCode=ex"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(jsonPath("code").value("000000"))
					;

//			ResponseEntity ret = new ResponseEntity("test");
//			when(userService.getNameById(5L)).thenReturn(ret);


//			String content = result.getResponse().getContentAsString();
//			System.out.println("test--------------" + content);
//			logger.debug("result :{}" + result.getResponse().getContentAsString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public static void main(String[] args) {
//
//		Map<String, String> propsMap = new HashMap<String, String>();
//		propsMap.put("id", "5");
//
//		Map<String, String> header = new HashMap<String, String>();
//		header.put("Content-uid", "microsite");
//		HttpClientUtils.setHeader(header);
//
//		try {
//			String result = HttpClientUtils
//					.doPost("http://192.168.1.61:8080/auth/api/1.0.0/zhima/queryBankCardValidity",
//							propsMap);
//			System.out.println(result);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

//	}
}
