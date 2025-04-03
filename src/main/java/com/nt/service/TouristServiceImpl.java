package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Tourist;
import com.nt.error.TouristNotFoundException;
import com.nt.repository.TouristRepository;

@Service
public class TouristServiceImpl implements TouristService {

	@Autowired
	private TouristRepository repository;

	@Override
	public String registerTourist(Tourist tourist) {

		int id = repository.save(tourist).getTid();

		return "Tourist is daved with id ::" + id;
	}

	@Override
	public List<Tourist> showAllTourist() {

		List<Tourist> list = repository.findAll();

		list.sort((t1, t2) -> t1.getBudget().compareTo(t2.getBudget()));

		return list;
	}

	@Override
	public List<Tourist> serachByBudgetRange(double start, double end) {

		return repository.searchTouristByBudgetRange(start, end);
	}

	@Override
	public Tourist showTouristById(int id) {
		return repository.findById(id).orElseThrow(() -> new TouristNotFoundException(id + " Tourist not Found"));
	}

	@Override
	public String updateTourist(Tourist tourist) {

		Optional<Tourist> opt = repository.findById(tourist.getTid());
		if (opt.isPresent()) {
			repository.save(tourist);

			return tourist.getTid() + " Tourist updated";
		}

		return tourist.getTid() + " Tourist not Found for update";
	}

	@Override
	public String updateTouristBudget(int id, float percentage) {

		Optional<Tourist> opt = repository.findById(id);
		if (opt.isPresent()) {

			Tourist tourist = opt.get();

			tourist.setBudget(tourist.getBudget() + tourist.getBudget() * percentage / 100.0);

			repository.save(tourist);

			return id + " Tourist budget is updated";
		}

		return id + " Tourist not Found for update";
	}

	@Override
	public String removeTouritByid(int id) {
		
		Optional<Tourist> opt=repository.findById(id);
		
		if(opt.isPresent())
		{
			repository.deleteById(id);
			
			return id+" tourist deleted";
		}
		return id+ " tourist not found for deletion";
	}

	@Override
	public String removeTouritByPackageType(String type) {

		int count=repository.removeTouristByPackageType(type);
		
		return count+" no of records deleted";
	}

}
