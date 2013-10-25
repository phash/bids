package de.mroedig.sec;

/**
 * Dubiose spezialisierung eines von Spring-sec-framework vorgegebenen Encoders.
 * 
 */
public class BidsPasswordEncoder {

	/** ehemals myVerschlüssler */
	private static final SHA384WhithSaltHashMaker VERSCHLUESSLER = new SHA384WhithSaltHashMaker();

	public String encodePassword(final String pRawPass, final Object pSalt) {
		return VERSCHLUESSLER.getStringSaltedHash(pRawPass, (String) pSalt);

	}

	public boolean isPasswordValid(final String pEncPass,
			final String pRawPass, final Object pSalt) {
		return pEncPass.equals(encodePassword(pRawPass, pSalt));
	}

}
