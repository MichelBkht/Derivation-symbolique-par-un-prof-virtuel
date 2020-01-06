package edu.projet.expressions;

import java.util.HashMap;

import edu.projet.interfaces.DerivationVisitor;
import edu.projet.interfaces.SimplificationVisitor;

public class Soustraction extends Addition {
	
    public Soustraction(Expression exprG, Expression exprD) {
		super(exprG, new Multiplication(new Constante(-1), exprD));
	}
    
	@Override
	public String asString() {		
		return this.exprG.asString() + " - " + exprD.exprD.asString();
	}

	@Override
	public double evaluer(HashMap<String, Double> liste) {
		return  this.exprG.evaluer(liste) + this.exprD.evaluer(liste);
	}
	
	@Override
	public <R> R accept(SimplificationVisitor<R> visitor) {
		try{
			return (visitor).visit(this);
		} 
		catch(ClassCastException exception) {
			return null;
		}
	}
	
	@Override
	public <R> R accept(DerivationVisitor<R> visitor, String dx) {
		try{
			return (visitor).visit(this, dx);
		} 
		catch(ClassCastException exception) {
			return null;
		}
	}

}
