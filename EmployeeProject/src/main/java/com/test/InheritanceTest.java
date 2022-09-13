package com.test;

import java.util.List;

import com.model.TrainerCrud;
import com.pojo.Developer;
import com.pojo.NeoTrainer;
import com.pojo.Trainer;

public class InheritanceTest {
		public static void main(String[] args) {
			TrainerCrud trcrud=new TrainerCrud();
			/*
			Trainer tr=new Trainer();
			tr.setEmpId(77);
			tr.setEmpName("Poonam");
			tr.setEmpSalary(34000);
			tr.setExtraPayPerHr(450);
			tr.setQualification("ME");
			tr.setTrainingTechnology("Java");		
			boolean b=trcrud.addTrainer(tr);
			System.out.println(b);
			*/
			// Test is for Developer
			/*
			Developer d=new Developer();
			d.setClientCompany("TCS");
			d.setEmpId(15);
			d.setEmpName("Prabhat");
			d.setEmpSalary(23000);
			d.setQualification("BE");
			d.setTechnology("Python");
			boolean b=trcrud.addDeveloper(d);
			System.out.println(b);
			*/
			/*
			List<Trainer> trainerList= trcrud.getAllTrainers();
			trainerList.forEach(System.out::println);*/
			NeoTrainer tr=new NeoTrainer();
			tr.setEmpId(66);
			tr.setEmpName("Pooja");
			tr.setEmpSalary(34000);
			tr.setExtraPayPerHr(600);
			tr.setQualification("BE");
			tr.setTrainingTechnology("Python");		
			boolean b=trcrud.addTrainer(tr);
			System.out.println(b);
		}
}
