package io.altar.jseproject.textInterface;

import io.altar.jseproject.utils.ScannerUtils;

public interface State {
	static final ScannerUtils SCANNERUTILS = new ScannerUtils();
	
	public int execute();
}
