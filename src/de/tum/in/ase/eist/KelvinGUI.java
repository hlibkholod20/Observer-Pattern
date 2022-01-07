package de.tum.in.ase.eist;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KelvinGUI extends TemperatureGUI {
	
	public KelvinGUI(TemperatureModel tempModel, Point location) {
		super("Kelvin Temperature", tempModel, location);
		addRaiseTempListener(new RaiseTempListener());
		addLowerTempListener(new LowerTempListener());
		addDisplayListener(new DisplayListener());
	}

	@Override
	public void onUpdate(Double newState) {
		setDisplay(Double.toString(TemperatureConverter.convertCelsiusToKelvin(newState.doubleValue())));
	}
	
	class RaiseTempListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			getModel().increaseK(1.0);
		}
	}

	class LowerTempListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			getModel().increaseK(-1.0);
		}
	}

	class DisplayListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			double value = getDisplay();
			getModel().setK(value);
		}
	}
}

