package kr.spring.ch10;

import java.util.List;

public class PerformanceMonitor {
	private List<Double> deviations;

	public void setDeviations(List<Double> deviations) {
		this.deviations = deviations;
	}

	@Override
	public String toString() {
		return "PerformanceMonitor [deviations=" + deviations + "]";
	}
}
