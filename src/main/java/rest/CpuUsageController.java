package rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

@RestController
public class CpuUsageController {
    @GetMapping("/cpuusage")
    public CpuUsage cpuusage() {
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        return new CpuUsage(osBean.getSystemLoadAverage() / osBean.getAvailableProcessors() * 100);
    }
}
