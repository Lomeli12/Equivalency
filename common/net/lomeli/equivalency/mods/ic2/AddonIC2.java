package net.lomeli.equivalency.mods.ic2;

import net.lomeli.equivalency.Equivalency;
import cpw.mods.fml.common.Loader;

public class AddonIC2 
{
	public static boolean checkIC2()
	{
		if (Loader.isModLoaded("IC2"))
		{
			try
			{
				Equivalency.numberInstalled++;
				return true;
			}
			catch(Exception ex)
			{
				return false;
			}
		}
		else
		{
			System.out.println("IC2 not found, ignoring");
			return false;
		}
	}
}
