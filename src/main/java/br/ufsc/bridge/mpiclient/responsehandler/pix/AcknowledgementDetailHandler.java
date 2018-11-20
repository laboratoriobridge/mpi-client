package br.ufsc.bridge.mpiclient.responsehandler.pix;

import br.ufsc.bridge.mpiclient.api.PIXResponse;
import br.ufsc.bridge.mpiclient.responsehandler.DefaultAttributeHandler;
import br.ufsc.bridge.mpiclient.responsehandler.XmlTextHandler;

public class AcknowledgementDetailHandler extends DefaultAttributeHandler<PIXResponse> {
	public AcknowledgementDetailHandler() {
		super("acknowledgementDetail");
		this.handlers.add(new XmlTextHandler("text", errorText ->
				this.current.appendErrorMessage(errorText)
		));
	}
}
