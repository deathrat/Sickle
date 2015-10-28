package com.urcraft.wurm.sickle.common.asm;

import com.urcraft.wurm.sickle.common.asm.transformers.SickleTransformer;
import com.urcraft.wurm.sickle.common.asm.transformers.TransformersHandler;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.commons.AdviceAdapter;

public abstract class SickleAdviceAdapter extends AdviceAdapter implements ISickleMethodVisitor
{
    private SickleTransformer _transformer;
    private int _access;
    private String _name, _desc, _signature, _className;
    private String[] _exceptions;

    public SickleAdviceAdapter(MethodVisitor mv, int access, String name, String desc, String signature, String[] exceptions, String className)
    {
        super(ASM5, mv, access, name, desc);
        _transformer = TransformersHandler.getInstance().transformers.get(className);
        _access = access;
        _name = name;
        _desc = desc;
        _signature = signature;
        _exceptions = exceptions;
        _className = className;
    }

    @Override
    public void visitLabel(Label label)
    {
        boolean ret = _transformer.visitLabel(label, this);
        if(ret)
            super.visitLabel(label);
    }

    @Override
    public void visitInsn(int opcode)
    {
        boolean ret = _transformer.visitInsn(opcode, this);
        if(ret)
            super.visitInsn(opcode);
    }

    @Override
    public void visitVarInsn(int opcode, int var)
    {
        boolean ret = _transformer.visitVarInsn(opcode, var, this);
        if(ret)
            super.visitVarInsn(opcode, var);
    }

    @Override
    public void visitFieldInsn(int opcode, String owner, String name, String desc)
    {
        boolean ret = _transformer.visitFieldInsn(opcode, owner, name, desc, this);
        if(ret)
            super.visitFieldInsn(opcode, owner, name, desc);
    }

    @Override
    public void visitIntInsn(int opcode, int operand)
    {
        boolean ret = _transformer.visitIntInsn(opcode, operand, this);
        if(ret)
            super.visitIntInsn(opcode, operand);
    }

    @Override
    public void visitLdcInsn(Object cst)
    {
        boolean ret = _transformer.visitLdcInsn(cst, this);
        if(ret)
            super.visitLdcInsn(cst);
    }

    @Override
    public void visitTypeInsn(int opcode, String type)
    {
        boolean ret = _transformer.visitTypeInsn(opcode, type, this);
        if(ret)
            super.visitTypeInsn(opcode, type);
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf)
    {
        boolean ret = _transformer.visitMethodInsn(opcode, owner, name, desc, itf, this);
        if(ret)
            super.visitMethodInsn(opcode, owner, name, desc, itf);
    }

    @Override
    public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object... bsmArgs)
    {
        boolean ret = _transformer.visitInvokeDynamicInsn(name, desc, bsm, bsmArgs, this);
        if(ret)
            super.visitInvokeDynamicInsn(name, desc, bsm, bsmArgs);
    }

    @Override
    public void visitJumpInsn(int opcode, Label label)
    {
        boolean ret = _transformer.visitJumpInsn(opcode, label, this);
        if(ret)
            super.visitJumpInsn(opcode, label);
    }

    @Override
    public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels)
    {
        boolean ret = _transformer.visitLookupSwitchInsn(dflt, keys, labels, this);
        if(ret)
            super.visitLookupSwitchInsn(dflt, keys, labels);
    }

    @Override
    public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels)
    {
        boolean ret = _transformer.visitTableSwitchInsn(min, max, dflt, labels, this);
        if(ret)
            super.visitTableSwitchInsn(min, max, dflt, labels);
    }

    @Override
    public void visitTryCatchBlock(Label start, Label end, Label handler, String type)
    {
        boolean ret = _transformer.visitTryCatchBlock(start, end, handler, type, this);
        if(ret)
            super.visitTryCatchBlock(start, end, handler, type);
    }

    @Override
    public void visitCode()
    {
        _transformer.visitCode(this);
    }

    @Override
    protected void onMethodEnter()
    {
        System.out.println("Method entered: " + _name);
        _transformer.onMethodEnter(this);
    }

    @Override
    protected void onMethodExit(int opcode)
    {
        _transformer.onMethodExit(opcode, this);
    }

    @Override
    public String getName() { return _name; }

    @Override
    public String getDesc()
    {
        return _desc;
    }

    @Override
    public String getSignature()
    {
        return _signature;
    }

    @Override
    public String getClassName()
    {
        return _className;
    }

    @Override
    public MethodVisitor getParent()
    {
        return mv;
    }

    @Override
    public int getAccess()
    {
        return _access;
    }

    @Override
    public String[] getExceptions()
    {
        return _exceptions;
    }
}
