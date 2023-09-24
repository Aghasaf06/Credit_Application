package buta.creditapplication.Service;

import buta.creditapplication.Entity.Credit;
import buta.creditapplication.Repository.ICreditRepository;
import org.springframework.stereotype.Service;

@Service
public class CreditService {

    private ICreditRepository iCreditRepository;

    public CreditService(ICreditRepository iCreditRepository) {
        this.iCreditRepository = iCreditRepository;
    }

    public void saveCredit(Credit credit) {
        iCreditRepository.save(credit);
    }
}
