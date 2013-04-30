package net.lomeli.equivalency.magiks;

import cpw.mods.fml.common.Loader;

public class AddonMechroMagiks 
{

	public static boolean checkMM()
	{
		if (Loader.isModLoaded("magiks"))
		{
			try
			{
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
