package brivan.tech.brivan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class BrivanApplication {

	public BrivanApplication() {
	}
	public static void main(String[] args) {
		SpringApplication.run(BrivanApplication.class, args);
	}
	
public class DeviceController {
	
		/**
		 * @param model
		 * @return
		 */
		@GetMapping("/devices")
		public String getDevices(Model model) {
			int deviceCount = getDeviceCount(); // Method to get the number of devices connected to the network
			model.addAttribute("deviceCount", deviceCount);
			return "devices";
		}

		private int getDeviceCount() {
			return 0;
		}
	}
	
}
