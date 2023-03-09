package com.hemebiotech.analytics;

import java.util.List;

public interface ISymptomReader {
	/* return a list of symtpoms, if symptoms not present, return null*/
	List<String> getSymptoms ();
}
