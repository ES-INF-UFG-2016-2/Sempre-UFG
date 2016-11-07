package br.ufg.inf.stubs;

import java.io.IOException;
import java.io.InputStream;

public class WebServiceCercompMock {
	public InputStream consultarWebServiceEgresso() throws IOException{
		return new InputStream() {
			@Override
			public int read() throws IOException {
				return 0;
			}
		};
	}
}
