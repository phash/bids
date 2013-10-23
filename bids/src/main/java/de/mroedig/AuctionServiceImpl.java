package de.mroedig;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.mroedig.dao.AuctionDao;
import de.mroedig.dao.BenutzerDao;
import de.mroedig.entities.Auction;

@Service
public class AuctionServiceImpl implements AuctionService {

	@Autowired
	private BenutzerDao bildDao;

	@Autowired
	private AuctionDao auctionDao;

	@Override
	@Transactional
	public void createNewAuction(Auction neueAuktion) {
		neueAuktion.setStartZeitpunkt(new Date());

		auctionDao.persistiere(neueAuktion);
	}

}
