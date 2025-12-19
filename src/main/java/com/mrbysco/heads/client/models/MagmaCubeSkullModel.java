package com.mrbysco.heads.client.models;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.object.skull.SkullModelBase;

import java.util.Arrays;

public class MagmaCubeSkullModel extends SkullModelBase {
	private final ModelPart[] bodyCubes = new ModelPart[8];

	public MagmaCubeSkullModel(ModelPart root) {
		super(root);
		Arrays.setAll(this.bodyCubes, (id) -> root.getChild(getSegmentName(id)));
	}

	public static MeshDefinition createMagmaCubeHead() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		for (int i = 0; i < 8; i++) {
			int j = 0;
			int k = 0;
			if (i > 0 && i < 4) {
				k += 9 * i;
			} else if (i > 3) {
				j = 32;
				k += 9 * i - 36;
			}

			partdefinition.addOrReplaceChild(
					getSegmentName(i), CubeListBuilder.create().texOffs(j, k).addBox(-4.0F, (float) (-8 + i), -4.0F, 8.0F, 1.0F, 8.0F), PartPose.ZERO
			);
		}
		return meshdefinition;
	}

	private static String getSegmentName(int id) {
		return "cube" + id;
	}

	public static LayerDefinition createSkullModel() {
		MeshDefinition meshdefinition = createMagmaCubeHead();
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(State state) {
		super.setupAnim(state);
		this.root.yRot = state.yRot * ((float) Math.PI / 180F);
		this.root.xRot = state.xRot * ((float) Math.PI / 180F);
	}
}
