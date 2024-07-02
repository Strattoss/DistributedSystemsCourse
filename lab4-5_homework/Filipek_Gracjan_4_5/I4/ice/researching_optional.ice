
#ifndef OPT_ICE
#define OPT_ICE

module Demo
{
  class C
  {
    optional(1) int integer;
  }

  sequence<int> IntArray;

  exception MyException {
    optional(1) int code;
  }

  interface OptionalResearchServant
  {
    C sendC(C c);
    void throwException(bool withOptional) throws MyException;

    IntArray sequenceMethod(IntArray intArray);

    void voidMethod();
    optional(2) int optionalParameters(optional(1) int integer);
  };

};

#endif
