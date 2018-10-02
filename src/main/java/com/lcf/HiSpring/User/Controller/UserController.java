package com.lcf.HiSpring.User.Controller;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lcf.HiSpring.User.to.User;
import com.lcf.HiSpring.utils.StringUtils;



@Controller
@RequestMapping("userBean")
//@Scope("view")

public class UserController {

	@RequestMapping(value="/login"/*,method= {RequestMethod.OPTIONS,RequestMethod.POST}*/)
	@ResponseBody
	public String login(@RequestBody String reqBody) {
		// response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200"); 
		//response.setHeader("Access-Control-Allow-Origin", "*"); 
		System.err.println(reqBody);
		JSONObject json = JSON.parseObject(reqBody);
		ModelAndView mv=new ModelAndView();
		String page="";
		JSONObject jsonObject=new JSONObject();
		User user =new User();
		user.setUserName(json.getString("userName"));
		user.setPassword(json.getString("password"));
		System.out.println(user.toString());
		if(!StringUtils.noBlank(user.getUserName(),user.getPassword())) {
			//mv.add
			jsonObject.put("msg", "UserName and Password can not be blank.");
		}else {
			if("lcf".equals(user.getUserName())&&"520".equals(user.getPassword())) {

				//jsonObject.put("user", user);
				//httpServletRequest.getSession().setAttribute("user", user.getUserName());
				jsonObject.put("msg", "login successfully.");
				page="NewFile.jsp";
				mv.setViewName(page);
			}else {
				jsonObject.put("msg", "UserName or Password is not correct.");
			}
		}
		//ModelAndView mv= new ModelAndView();
		mv.addObject("msg", jsonObject);
		
		System.out.println("test for ");
		
		return jsonObject.toJSONString();
	}
	
	
}
