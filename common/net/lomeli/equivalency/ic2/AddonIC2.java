package net.lomeli.equivalency.ic2;

import cpw.mods.fml.common.Loader;

public class AddonIC2 
{
	public static boolean checkIC2()
	{
		if (Loader.isModLoaded("IC2"))
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
			System.out.println("IC2 not found, ignoring");
			return false;
		}
	}
}
