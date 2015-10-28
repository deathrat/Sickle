package com.urcraft.wurm.sickle.common.asm.transformers;


import com.urcraft.wurm.sickle.common.asm.ISickleMethodVisitor;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

public abstract class SickleTransformer
{
    private MethodVisitor _visitor;

    public SickleTransformer(String... classPath)
    {
        String[] _classPath = new String[classPath.length];
        for(int i = 0; i < classPath.length; i++)
        {
            if(classPath[i].contains("."))
                classPath[i] = classPath[i].replace('.', '/');
            _classPath[i] = classPath[i];
            TransformersHandler.getInstance().transformers.put(classPath[i], this);
        }
    }

    public abstract void visitCode(ISickleMethodVisitor smv);

    public abstract void onMethodEnter(ISickleMethodVisitor smv);

    public abstract void onMethodExit(int opcode, ISickleMethodVisitor smv);

    public boolean visitLabel(Label label, ISickleMethodVisitor smv) {return true;}

    public boolean visitInsn(int opcode, ISickleMethodVisitor smv) {return true;}

    public boolean visitVarInsn(int opcode, int var, ISickleMethodVisitor smv) {return true;}

    public boolean visitFieldInsn(int opcode, String owner, String name, String desc, ISickleMethodVisitor smv) {return true;}

    public boolean visitIntInsn(int opcode, int operand, ISickleMethodVisitor smv) {return true;}

    public boolean visitLdcInsn(Object cst, ISickleMethodVisitor smv) {return true;}

    public boolean visitTypeInsn(int opcode, String type, ISickleMethodVisitor smv) {return true;}

    public boolean visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf, ISickleMethodVisitor smv) {return true;}

    public boolean visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object[] bsmArgs, ISickleMethodVisitor smv) {return true;}

    public boolean visitJumpInsn(int opcode, Label label, ISickleMethodVisitor smv) {return true;}

    public boolean visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels, ISickleMethodVisitor smv) {return true;}

    public boolean visitTableSwitchInsn(int min, int max, Label dflt, Label[] labels, ISickleMethodVisitor smv) {return true;}

    public boolean visitTryCatchBlock(Label start, Label end, Label handler, String type, ISickleMethodVisitor smv) {return true;}
}

