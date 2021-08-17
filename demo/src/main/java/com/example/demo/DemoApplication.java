package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@CrossOrigin
public class DemoApplication {
	HomeController h = new HomeController();

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/eval")
	public String eval (@RequestParam(value = "xx") String x , @RequestParam(value = "yy") String y ,@RequestParam(value = "operator") Character op ){
		float z=0;
		float x1= Float.valueOf(x);
		float y1= Float.valueOf(y);
		if(op=='+'){
			z = h.Add(x1, y1);
		}
		else if(op=='-'){
			z=h.Subtract(x1, y1);
		}
		else if(op=='*'){
			z=h.multiply(x1, y1);
		}
		else if(op=='/'){
			String e = h.divide(x1, y1);
			return e;
		}
		else if(op=='n'){
			z=h.multiply(-1, y1);
		}
		else if(op=='s'){
			double d1 = Double.valueOf(y);
			String r = h.squareroot(d1);
			return r;
		}
		else if(op=='p'){
			z=h.multiply(y1, y1);
		}
		else if(op=='i'){
			String e = h.divide(1, y1);
			return e;
		}
		else if(op=='c'){
			z=(x1*y1)/100;
		}
		String s = Float.toString(z);
		
		return s;


	}

}
