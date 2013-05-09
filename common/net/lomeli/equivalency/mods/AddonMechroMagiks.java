package net.lomeli.equivalency.mods;

import net.lomeli.equivalency.Equivalency;
import cpw.mods.fml.common.Loader;

public class AddonMechroMagiks 
{

	public static boolean checkMM()
	{
		if (Loader.isModLoaded("magiks"))
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
			System.out.println("MechroMagiks not found, ignoring");
			return false;
		}
	}
}
