package com.urcraft.wurm.sickle.server.asm.transformers;

import com.urcraft.wurm.sickle.common.asm.ISickleMethodVisitor;
import com.urcraft.wurm.sickle.common.asm.transformers.SickleTransformer;
import org.objectweb.asm.MethodVisitor;

public class CreaturesTransformer extends SickleTransformer
{
    public CreaturesTransformer()
    {
        super("com/wurmonline/server/creatures/Creatures", "com/wurmonline/server/creatures/CreatureTemplateFactory");
    }

    @Override
    public void visitCode(ISickleMethodVisitor smv)
    {

        MethodVisitor mv = smv.getParent();

        if("(Ljava/lang/String;Ljava.sql.ResultSet;Lcom/wurmonline/server/creatures/Creature;)V".equals(smv.getDesc()) && "intializeCreature".equals(smv.getName()))
        {

        }
    }

    @Override
    public void onMethodEnter(ISickleMethodVisitor smv)
    {

    }

    @Override
    public void onMethodExit(int opcode, ISickleMethodVisitor smv)
    {

    }


}
