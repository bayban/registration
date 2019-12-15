package com.bayban.util;

import flexjson.transformer.AbstractTransformer;

public class NullExcludeTransformer extends AbstractTransformer {

	@Override
	public Boolean isInline() {
		return true;
	}
	
	@Override
	public void transform(Object arg0) {
		// Do nothing, null objects are not serialized.
		return;
	}

}