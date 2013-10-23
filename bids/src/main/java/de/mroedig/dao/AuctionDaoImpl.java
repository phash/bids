package de.mroedig.dao;

import org.springframework.stereotype.Repository;

import de.mroedig.entities.Auction;

@Repository(value = "auctionDao")
public class AuctionDaoImpl extends BasisDaoImpl<Auction> implements AuctionDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3004120737879630093L;

}
