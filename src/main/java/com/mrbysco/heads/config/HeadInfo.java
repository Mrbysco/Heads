package com.mrbysco.heads.config;

import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.Locale;

public class HeadInfo {
	public final ModConfigSpec.BooleanValue enableCreeperDrop;
	public final ModConfigSpec.DoubleValue dropRate;


	public HeadInfo(ModConfigSpec.Builder builder, String mobName, double rate) {
		String configName = getCamelCase(mobName);

		builder.comment(mobName + " settings")
				.push(configName);

		enableCreeperDrop = builder
				.comment("Enable charged creeper explosion to drop a " + mobName + " head")
				.define(configName + "EnableCreeperDrop", true);

		dropRate = builder
				.comment("Defines the drop rate for the " + mobName + " head (0 to disable) [Default: 0.025]")
				.defineInRange(configName + "DropRate", rate, 0, 1);

		builder.pop();
	}

	private String getCamelCase(String input) {
		if (input.contains(" ")) {
			String[] words = input.split("[\\W_]+");
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < words.length; i++) {
				String word = words[i];
				if (i == 0) {
					word = word.isEmpty() ? word : word.toLowerCase();
				} else {
					word = word.isEmpty() ? word : Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
				}
				builder.append(word);
			}
			return builder.toString();
		} else {
			return input.toLowerCase(Locale.ROOT);
		}
	}
}
