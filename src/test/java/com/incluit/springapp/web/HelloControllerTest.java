package com.incluit.springapp.web;


/*import com.incluit.springapp.web.controllers.HelloController;*/
import com.incluit.springapp.web.controllers.HelloController;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.assertEquals;

/**
 * Created by nlosada on 17/05/18.
 */

public class HelloControllerTest {

    @Test
    public void testHandleRequestView() throws Exception{
        HelloController controller = new HelloController();
        ModelAndView modelAndView = controller.handleRequest(null, null);
        assertEquals("hello", modelAndView.getViewName());
    }

}
