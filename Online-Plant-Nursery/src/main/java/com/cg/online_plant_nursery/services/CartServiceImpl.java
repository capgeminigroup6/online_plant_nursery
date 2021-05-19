package com.cg.online_plant_nursery.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.online_plant_nursery.dao.AdminDAO;
import com.cg.online_plant_nursery.dao.CartDAO;
import com.cg.online_plant_nursery.dao.CustomerDAO;
import com.cg.online_plant_nursery.dao.FertilizerDAO;
import com.cg.online_plant_nursery.dao.GardenDecorDAO;
import com.cg.online_plant_nursery.dao.PlantDAO;
import com.cg.online_plant_nursery.dao.PlanterDAO;
import com.cg.online_plant_nursery.dao.SeedDAO;
import com.cg.online_plant_nursery.dao.UserCartDAO;
import com.cg.online_plant_nursery.entity.Cart;
import com.cg.online_plant_nursery.entity.Customer;
import com.cg.online_plant_nursery.entity.Fertilizer;
import com.cg.online_plant_nursery.entity.GardenDecor;
import com.cg.online_plant_nursery.entity.Plant;
import com.cg.online_plant_nursery.entity.Planter;
import com.cg.online_plant_nursery.entity.Seed;
import com.cg.online_plant_nursery.entity.UserCart;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;
import com.cg.online_plant_nursery.utils.NotAuthorizedException;
import com.cg.online_plant_nursery.utils.OutOfStockException;

@Service
public class CartServiceImpl implements ICartService{
	@Autowired
	CartDAO dao;
	@Autowired
	CustomerDAO customerDao;
	@Autowired
	UserCartDAO usercartDao;
	@Autowired
	PlantDAO plantDao;
	@Autowired
	SeedDAO seedDao;
	@Autowired
	PlanterDAO planterDao;		//autowires these services with repository classes
	@Autowired
	FertilizerDAO fertilizerDao;
	@Autowired
	GardenDecorDAO gardenDecorDao;
	@Autowired
	AdminDAO admindao;
	
	List<Cart> CartList = new ArrayList<>();	
	@Override
	public void addPlantToCart(long customerID, long plantID, int quantity) throws IDNotFoundException,OutOfStockException {
		CartList = dao.findAll();
		Plant pl = plantDao.getPlantById(plantID);
		Customer customer = customerDao.getCustomerById(customerID); 
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID && c.getPlant() != null && c.getPlant().getId() == plantID)  {
				int quant = c.getPlant_quantity();
				c.setPlant_quantity(quant+quantity);
				c.setTotalamount(c.getTotalamount()+(quantity*pl.getPrice()));	//if cart has the product already with 0 quantity
				dao.save(c);
				return;
			}
		}
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID && c.getPlant() == null) {
				c.setPlant(pl);
				c.setPlant_quantity(quantity);
				c.setTotalamount(c.getTotalamount()+(quantity*pl.getPrice()));	//if cart is empty
				dao.save(c);
				return;
			}
		}
		Cart c2 = new Cart();
		c2.setCustomer(customer);
		c2.setPlant(pl);
		c2.setPlant_quantity(quantity);
		c2.setPlanter_quantity(0);
		c2.setFertlizer_quantity(0);
		c2.setGarden_decor_quantity(0);
		c2.setSeed_quantity(0);
		c2.setTotalamount(quantity*pl.getPrice());		//if a product of same category is already in the cart
		dao.save(c2);
		return;
		
//			for(Cart c : CartList) {
//				if(c.getCustomer().getId() == customerID) {
//					if(plantDao.existsById(plantID)) {
//						
//							if(c.getPlant() != null) {
//								Cart c2 = new Cart();
//								for(Cart c1 : CartList) {
//									if(c1.getCustomer().getId() == customerID && c1.getPlant().getId() == plantID) {
//										int quant = c1.getPlant_quantity();
//										c1.setPlant_quantity(quant+quantity);
//										c1.setTotalamount(c1.getTotalamount()+(quantity*pl.getPrice()));	//if cart has the product already with 0 quantity
//										dao.save(c1);
//										return;
//									}
//								}
//								c2.setCustomer(c.getCustomer());
//								c2.setPlant(pl);
//								
//								c2.setPlant_quantity(quantity);
//								c2.setPlanter_quantity(0);
//								c2.setFertlizer_quantity(0);
//								c2.setGarden_decor_quantity(0);
//								c2.setSeed_quantity(0);
//								
//								c2.setTotalamount(quantity*pl.getPrice());		//if a product of same category is already in the cart
//								dao.save(c2);
//								return;
//							}
//							c.setPlant(pl);
//							c.setPlant_quantity(quantity);
//							c.setTotalamount(c.getTotalamount()+(quantity*pl.getPrice()));	//if cart is empty
//							dao.save(c);
//							return;
//					}
//					throw new OutOfStockException();	//if product is not found in the list
//				}
//			}
//			throw new IDNotFoundException();	//if customer id is not found in the list
	}
			
	@Override
	public void addSeedToCart(long customerID, long seedID, int quantity) throws IDNotFoundException,OutOfStockException {
		CartList = dao.findAll();
		Seed s = seedDao.getSeedById(seedID);
		Customer customer = customerDao.getCustomerById(customerID); 
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID  && c.getSeed() != null && c.getSeed().getId() == seedID) {
				int quant = c.getSeed_quantity();
				c.setSeed_quantity(quant+quantity);
				c.setTotalamount(c.getTotalamount()+(quantity*s.getPrice()));	//if cart has the product already with 0 quantity
				dao.save(c);
				return;
			}
		}
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID && c.getSeed() == null) {
				c.setSeed(s);
				c.setSeed_quantity(quantity);
				c.setTotalamount(c.getTotalamount()+(quantity*s.getPrice()));	//if cart is empty
				dao.save(c);
				return;
			}
		}
		Cart c2 = new Cart();
		c2.setCustomer(customer);
		c2.setSeed(s);
		c2.setSeed_quantity(quantity);
		c2.setPlant_quantity(0);
		c2.setPlanter_quantity(0);
		c2.setFertlizer_quantity(0);
		c2.setGarden_decor_quantity(0);
		c2.setTotalamount(quantity*s.getPrice());	//if a product of same category is already in the cart
		dao.save(c2);
		return;
	}

	@Override
	public void addPlanterToCart(long customerID, long planterID, int quantity) throws IDNotFoundException,OutOfStockException {
		CartList = dao.findAll();
		Planter plr = planterDao.getPlanterById(planterID);
		Customer customer = customerDao.getCustomerById(customerID); 
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID && c.getPlanter()!=null && c.getPlanter().getId() == planterID) {
				int quant = c.getPlanter_quantity();
				c.setPlanter_quantity(quant+quantity);
				c.setTotalamount(c.getTotalamount()+(quantity*plr.getPrice()));	//if cart has the product already with 0 quantity
				dao.save(c);
				return;
			}
		}
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID && c.getPlanter()==null) {
				c.setPlanter(plr);
				c.setPlanter_quantity(quantity);
				c.setTotalamount(c.getTotalamount()+(quantity*plr.getPrice()));	//if cart is empty
				dao.save(c);
				return;
			}
		}
		Cart c2 = new Cart();
		c2.setCustomer(customer);
		c2.setPlanter(plr);
		c2.setPlanter_quantity(quantity);
		c2.setPlant_quantity(0);
		c2.setFertlizer_quantity(0);
		c2.setGarden_decor_quantity(0);
		c2.setSeed_quantity(0);
		c2.setTotalamount(quantity*plr.getPrice());
		dao.save(c2);	//if a product of same category is already in the cart
		return;
	}

	@Override
	public void addGardenDecorToCart(long customerID, long gardenDecorID, int quantity) throws IDNotFoundException,OutOfStockException {
		CartList = dao.findAll();
		GardenDecor gd = gardenDecorDao.getDecorById(gardenDecorID);
		Customer customer = customerDao.getCustomerById(customerID); 
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID && c.getGardendecor() != null && c.getGardendecor().getId() == gardenDecorID) {
				int quant = c.getGarden_decor_quantity();
				c.setGarden_decor_quantity(quant+quantity);
				c.setTotalamount(c.getTotalamount()+(quantity*gd.getPrice()));	//if cart has the product already with 0 quantity
				dao.save(c);
				return;
			}
		}
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID && c.getGardendecor() == null) {
				c.setGardendecor(gd);
				c.setGarden_decor_quantity(quantity);
				c.setTotalamount(c.getTotalamount()+(quantity*gd.getPrice()));	//if cart is empty
				dao.save(c);
				return;
			}
		}
		Cart c2 = new Cart();
		c2.setCustomer(customer);
		c2.setGardendecor(gd);
		c2.setGarden_decor_quantity(quantity);
		c2.setPlant_quantity(0);
		c2.setPlanter_quantity(0);					//if a product of same category is already in the cart
		c2.setFertlizer_quantity(0);
		c2.setSeed_quantity(0);
		c2.setTotalamount(quantity*gd.getPrice());
		dao.save(c2);
		return;
	}

	@Override
	public void addFertilizerToCart(long customerID, long fertilizerID, int quantity) throws IDNotFoundException,OutOfStockException {
		CartList = dao.findAll();
		Fertilizer fz = fertilizerDao.getFertilizerById(fertilizerID);
		Customer customer = customerDao.getCustomerById(customerID); 
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID && c.getFertilizer() != null && c.getFertilizer().getId() == fertilizerID) {
				int quant = c.getFertlizer_quantity();
				c.setFertlizer_quantity(quant+quantity);	
				c.setTotalamount(c.getTotalamount()+(quantity*fz.getPrice()));	//if cart has the product already with 0 quantity
				dao.save(c);
				return;
			}
		}
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID && c.getFertilizer() == null) {
				c.setFertilizer(fz);
				c.setFertlizer_quantity(quantity);
				c.setTotalamount(c.getTotalamount()+(quantity*fz.getPrice()));	//if cart is empty
				dao.save(c);
				return;
			}
		}
		Cart c2 = new Cart();
		c2.setCustomer(customer);
		c2.setFertilizer(fz);
		c2.setFertlizer_quantity(quantity);
		c2.setPlant_quantity(0);
		c2.setPlanter_quantity(0);
		c2.setGarden_decor_quantity(0);
		c2.setSeed_quantity(0);
		c2.setTotalamount(quantity*fz.getPrice());	//if a product of same category is already in the cart
		dao.save(c2);
		return;
	}

	@Override
	public void removePlantFromCart(long customerID, long plantID) throws IDNotFoundException {
		CartList = dao.findAll();
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID && c.getPlant().getId() == plantID) {
				c.setTotalamount(c.getTotalamount()-(plantDao.getPlantById(plantID).getPrice()*c.getPlant_quantity()));
				c.setPlant_quantity(0);
				dao.save(c);
				return;
			}
		}
		throw new IDNotFoundException();	//if customer id not present
	}

	@Override
	public void removeSeedFromCart(long customerID, long seedID) throws IDNotFoundException {
		CartList = dao.findAll();
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID && c.getSeed().getId() == seedID) {
				
				c.setTotalamount(c.getTotalamount()-(seedDao.getSeedById(seedID).getPrice()*c.getSeed_quantity()));
				c.setSeed_quantity(0);
				dao.save(c);
				return;
			}
		}
		throw new IDNotFoundException();		
	}

	@Override
	public void removePlanterFromCart(long customerID, long planterID) throws IDNotFoundException {
		CartList = dao.findAll();
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID && c.getPlanter().getId() == planterID) {
				
				c.setTotalamount(c.getTotalamount()-(planterDao.getPlanterById(planterID).getPrice()*c.getPlanter_quantity()));
				c.setPlanter_quantity(0);
				dao.save(c);
				return;
			}
		}
		throw new IDNotFoundException();		
	}

	@Override
	public void removeGardenDecorFromCart(long customerID, long gardenDecorID) throws IDNotFoundException {
		CartList = dao.findAll();
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID && c.getGardendecor().getId() == gardenDecorID) {
				
				c.setTotalamount(c.getTotalamount()-(gardenDecorDao.getDecorById(gardenDecorID).getPrice()*c.getGarden_decor_quantity()));
				c.setGarden_decor_quantity(0);
				dao.save(c);
				return;
			}
		}
		throw new IDNotFoundException();		
	}

	@Override
	public void removeFertilizerFromCart(long customerID, long fertilizerID) throws IDNotFoundException {
		CartList = dao.findAll();
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID && c.getFertilizer().getId() == fertilizerID) {
				
				c.setTotalamount(c.getTotalamount()-(fertilizerDao.getFertilizerById(fertilizerID).getPrice()*c.getFertlizer_quantity()));
				c.setFertlizer_quantity(0);
				dao.save(c);
				return;
			}
		}
		throw new IDNotFoundException();		
	}

	@Override
	public void updatePlantQuantity(long customerID, long plantID, int quantity) throws IDNotFoundException {
		CartList = dao.findAll();
		
		for(Cart c : CartList) {	
			if(c.getCustomer().getId() == customerID && c.getPlant().getId() == plantID) {
				c.setTotalamount(c.getTotalamount()-(plantDao.getPlantById(plantID).getPrice()*c.getPlant_quantity()));//remove the price with the previous quantity
				c.setTotalamount(c.getTotalamount()+(plantDao.getPlantById(plantID).getPrice()*quantity));//update the price with new quantity
				c.setPlant_quantity(quantity);
				dao.save(c);
				return;
			}
		}
		throw new IDNotFoundException();
	}

	@Override
	public void updateSeedQuantity(long customerID, long seedID, int quantity) throws IDNotFoundException {
		CartList = dao.findAll();
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID && c.getSeed().getId() == seedID) {
				c.setTotalamount(c.getTotalamount()-(seedDao.getSeedById(seedID).getPrice()*c.getSeed_quantity()));
				c.setTotalamount(c.getTotalamount()+(seedDao.getSeedById(seedID).getPrice()*quantity));
				c.setSeed_quantity(quantity);
				dao.save(c);
				return;
			}
		}
		throw new IDNotFoundException();		
	}

	@Override
	public void updatePlanterQuantity(long customerID, long planterID, int quantity) throws IDNotFoundException {
		CartList = dao.findAll();
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID && c.getPlanter().getId() == planterID) {
				c.setTotalamount(c.getTotalamount()-(planterDao.getPlanterById(planterID).getPrice()*c.getPlanter_quantity()));
				c.setTotalamount(c.getTotalamount()+(planterDao.getPlanterById(planterID).getPrice()*quantity));
				c.setPlanter_quantity(quantity);
				dao.save(c);
				return;
			}
		}
		throw new IDNotFoundException();			
	}

	@Override
	public void updateGardenDecorQuantity(long customerID, long gardenDecorID, int quantity)throws IDNotFoundException {
		CartList = dao.findAll();
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID && c.getGardendecor().getId() == gardenDecorID) {
				c.setTotalamount(c.getTotalamount()-(gardenDecorDao.getDecorById(gardenDecorID).getPrice()*c.getGarden_decor_quantity()));
				c.setTotalamount(c.getTotalamount()+(gardenDecorDao.getDecorById(gardenDecorID).getPrice()*quantity));
				c.setGarden_decor_quantity(quantity);
				dao.save(c);
				return;
			}
		}
		throw new IDNotFoundException();			
	}

	@Override
	public void updateFertilizerQuantity(long customerID, long fertilizerID, int quantity) throws IDNotFoundException {
		CartList = dao.findAll();
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID && c.getFertilizer().getId() == fertilizerID) {
				c.setTotalamount(c.getTotalamount()-(fertilizerDao.getFertilizerById(fertilizerID).getPrice()*c.getFertlizer_quantity()));
				c.setTotalamount(c.getTotalamount()+(fertilizerDao.getFertilizerById(fertilizerID).getPrice()*quantity));
				c.setFertlizer_quantity(quantity);
				dao.save(c);
				return;
			}
		}
		throw new IDNotFoundException();		
	}

	@Override
	public List<Cart> viewCart(long adminID) throws ListIsEmptyException,NotAuthorizedException {
		if(admindao.existsById(adminID)) {
			if(dao.findAll().isEmpty()) {
				throw new ListIsEmptyException();	// if cart list is empty
			}
			return dao.findAll();
		}
		throw new NotAuthorizedException();		//only admin have access to this
		
	}
	@Override
	public List<Cart> viewCart() throws ListIsEmptyException, NotAuthorizedException {
		if(dao.findAll().isEmpty()) {
			throw new ListIsEmptyException();	// if cart list is empty
		}
		return dao.findAll();
	}

	@Override
	public List<Cart> getOneCart(long customerID) throws IDNotFoundException {
		CartList = dao.findAll();
		List<Cart> usercartList = new ArrayList<>();
		boolean flag = false;
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID) {		//get particular customer's cart details
				flag = true;
				usercartList.add(c);
			}
		}
		if(flag == false) {
			throw new IDNotFoundException();
		}
		return usercartList;
	}
	

//	@Override
//	public List<UserCart> getOneCart(long customerID) throws IDNotFoundException {
//		CartList = dao.findAll();
//		List<UserCart> usercartList = new ArrayList<>();
//		UserCart usercart = new UserCart();
//		boolean flag = false;
//		
//		for(Cart c : CartList) {
//			if(c.getCustomer().getId() == customerID) {		//get particular customer's cart details
//				flag = true;
//				if(c.getPlant_quantity()!= 0 || c.getPlanter_quantity()!= 0 || c.getSeed_quantity() != 0 || c.getGarden_decor_quantity() !=  0 || c.getFertlizer_quantity() != 0) {
//					usercart.setCartid(c.getCartid());
//					usercart.setCustomerid(customerID);
//					if(c.getPlant_quantity()!= 0) {
//						usercart.setPlantid(c.getPlant().getId());
//						usercart.setPlant_quantity(c.getPlant_quantity());
//					}
//					if(c.getPlanter_quantity()!= 0 ) {
//						usercart.setPlanterid(c.getPlanter().getId());
//						usercart.setPlanter_quantity(c.getPlanter_quantity());
//					}
//					if(c.getSeed_quantity() != 0) {
//						usercart.setSeedid(c.getSeed().getId());
//						usercart.setSeed_quantity(c.getSeed_quantity());
//					}
//					if( c.getGarden_decor_quantity() !=  0) {
//						usercart.setGardendecorid(c.getGardendecor().getId());
//						usercart.setGarden_decor_quantity(c.getGarden_decor_quantity());
//					}
//					if(c.getFertlizer_quantity() != 0) {
//						usercart.setFertilizerid(c.getFertilizer().getId());
//						usercart.setFertlizer_quantity(c.getFertlizer_quantity());
//					}
//					usercart.setTotalamount(c.getTotalamount());
//					usercartList.add(usercart);
//					usercartDao.save(usercart);
//				}
//			}
//		}
//		if(flag == false) {
//			throw new IDNotFoundException();
//		}
//		return usercartList;
//	}
	
	@Override
	public Cart getOneCart1(long cartID) throws IDNotFoundException {
		if(dao.getCartById(cartID) != null) {
			return dao.getCartById(cartID);
		}
		else {
			throw new IDNotFoundException();
		}
	}


	@Override
	public double TotalCartAmount(long customerID) throws IDNotFoundException {
		double amt = 0;
		CartList = dao.findAll();
		boolean flag = false;
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID) {		//total cart amount of respective customer
				flag= true;		
				amt+=c.getTotalamount();
			}
		}
		if(flag == false) {
			throw new IDNotFoundException();
		}
		return amt;
	}

	@Override
	public void addPlantToCart(Cart cart) {
		dao.save(cart);
	}
	
	@Override
	public void removePlantFromCart(Cart cart) {
		dao.save(cart);
	}

	@Override
	public void updatePlantInCart(Cart cart) {
		dao.save(cart);		
	}

	
}
