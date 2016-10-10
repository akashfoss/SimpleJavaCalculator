package javaapplication1;

import java.util.*;
public class Fraction
{
	protected int numerator;
	protected int denominator;
	private static int count = 0;

	Fraction()
	{
		numerator = 1;
		denominator = 1;
		incrementCount();
	}	
	Fraction( int n )
	{
		numerator = n;
		denominator = 1;
		incrementCount();
	}
	Fraction( int n, int d )
	{
		numerator = n;
		denominator = d;
		incrementCount();
	}
	private static void incrementCount()
	{
		count++;
	}
	public static void printCount()
	{
		System.out.println("Count = "+count);
	}
	public void setNumerator(int n)
	{
		this.numerator = n;
	}
	public void setDenominator(int denominator)
	{
		this.denominator = denominator;
	}
	public int getNumerator()
	{
		return numerator;
	}
	public int getDenominator()
	{
		return denominator;
	}
	public void print()
	{
		if(denominator != 1)
			System.out.println("The fraction is "+ this.getNumerator() + "/" + this.getDenominator());
		else
			System.out.println("The fraction is "+this.getNumerator());
	}
	public void calc()
	{
		if(denominator % numerator == 0)
		{
			int a = numerator;
			int b = denominator/numerator;
			numerator = a;
			denominator = b;
		}
	}
	public void inverse()
	{	
		int tmp;
		tmp = numerator;
		numerator = denominator;
		denominator = tmp;
	}
	public boolean isProper()
	{
		if(numerator < denominator)
			return true;
		else
			return false;
	}
	public void reduce()
	{	
		if(isProper())
		{	
			for(int i = numerator; i >=2; i-- )
			{
				if( numerator % i == 0 && denominator % i  == 0)
				{
				denominator /= i;
				numerator /= i;
				}
			} 
		}
		else
		{
			for(int j = denominator; j >= 2; j-- )
			{
				if( numerator % j == 0 && denominator % j == 0)
				{
					denominator /= j;
					numerator /= j;
				}
			}
		}	
	}
	public Fraction computeInverse()
	{
		Fraction inv = new Fraction( denominator, numerator );
		return inv;
	}
	public Fraction add(Fraction fr)
	{
		int s, numerSum, denoSum;
		if(this.denominator == fr.getDenominator() )
		{
			s = this.numerator + fr.getNumerator();
			Fraction sum = new Fraction(s, this.denominator);
			return sum;
		}
		else
		{
			numerSum = (this.numerator * fr.denominator) + (fr.numerator * this.denominator) ;
			denoSum = this.denominator * fr.denominator;
			return (new Fraction(numerSum, denoSum));	
		}
	}
	public Fraction multiply(Fraction fr)
	{
		Fraction f = new Fraction();
                f.numerator = this.numerator * fr.numerator;
                f.denominator = this.denominator * fr.denominator;
                f.reduce();
                return f;
	}
        public Fraction divide(Fraction fr)
        {
            Fraction f = new Fraction();
            fr = fr.computeInverse();
            return this.multiply(fr);
        }
	/**This method adds two fractions!*/
	public static Fraction add1(Fraction f1, Fraction f2)
	{
		int numerSum, denoSum;
		if(f1.denominator == f2.denominator)
		{
			numerSum = f1.numerator + f2.numerator;
			return (new Fraction(numerSum, f1.denominator));
		}
		else
		{
			numerSum = (f1.numerator * f2.denominator) + (f2.numerator * f1.denominator) ;
			denoSum = f1.denominator * f2.denominator;
			return (new Fraction(numerSum, denoSum));	
		}
		
	}
	public boolean isEqual(Fraction f)
	{
		if(this.numerator == f.numerator && this.denominator == f.denominator)
			return true;
		else
			return false;
	}

	public Fraction sub(Fraction f)
	{
		int numerDiff;
		if(this.denominator == f.denominator)
		{
			numerDiff = this.numerator - f.numerator;
			return (new Fraction(numerDiff, this.denominator));
		}
		else
		{
			int denoSum;
			numerDiff = (f.numerator * this.denominator) - (this.numerator * f.denominator) ;
			denoSum = f.denominator * this.denominator;
			return (new Fraction(numerDiff, denoSum));
		}
	}
        public String toString()
        {
            return (numerator + "/" + denominator);
        }
}
	

