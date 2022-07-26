package com.lti.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HpLaptop implements Laptop {

	@Autowired
	HardDisk hardisk;

	public void details() {
		System.out.println("I am hppppppppppppppp");
		hardisk.hardDiskDetails();
	}

}
