package brivan.tech.brivan;

@SpringBootApplication
@Controller
public class BrivanApplication {

	public BrivanApplication() {
	}
	public static void main(String[] args) {
		SpringApplication.run(BrivanApplication.class, args);
	}
	
public class DeviceController {
	
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
