import sys
import Ice
import Demo

class IceClient:
    def __init__(self):
        self.status = 0
        self.communicator = None
        self.obj1 = None

    def initialize(self):

        try:
            self.communicator = Ice.initialize(sys.argv)
            base1 = self.communicator.stringToProxy("optionalResearcher:tcp -h 127.0.0.2 -p 10000 -z : udp -h 127.0.0.2 -p 10000 -z")
            self.obj1 = Demo.OptionalResearchServantPrx.checkedCast(base1)
            if not self.obj1:
                raise RuntimeError("Invalid proxy")

        except Ice.LocalException as e:
            print(e)
            self.status = 1
        except Exception as e:
            print(e)
            self.status = 1

    def shutdown(self):
        if self.communicator:
            try:
                self.communicator.destroy()
            except Exception as e:
                print(e)
                self.status = 1

    def handle_class_filled(self):
        c = Demo.C()
        c.integer = 10
        result_class_filled = self.obj1.sendC(c)

    def handle_class_empty(self):
        empty_c = Demo.C()
        result_class_empty = self.obj1.sendC(empty_c)

    def handle_throw_filled(self):
        try:
            self.obj1.throwException(True)
        except Demo.MyException as e:
            pass

    def handle_throw_empty(self):
        try:
            self.obj1.throwException(False)
        except Demo.MyException as e:
            pass

    def handle_sequence_filled(self):
        int_array_filled = [1, 2]
        result_sequence_filled = self.obj1.sequenceMethod(int_array_filled)

    def handle_sequence_one(self):
        int_array_one = [1]
        result_sequence_one = self.obj1.sequenceMethod(int_array_one)

    def handle_sequence_empty(self):
        empty_int_array = []
        result_sequence_empty = self.obj1.sequenceMethod(empty_int_array)

    def handle_void_method(self):
        self.obj1.voidMethod()

    def handle_optional_params_filled(self):
        optional_params_filled_result = self.obj1.optionalParameters(5)

    def handle_optional_params_empty(self):
        optional_params_empty_result = self.obj1.optionalParameters()

    def handle_all(self):
        self.handle_class_filled()
        self.handle_class_empty()
        self.handle_throw_filled()
        self.handle_throw_empty()
        self.handle_sequence_filled()
        self.handle_sequence_one()
        self.handle_sequence_empty()
        self.handle_void_method()
        self.handle_optional_params_filled()
        self.handle_optional_params_empty()

    def main(self):
        try:
            self.initialize()
            inpt = ''
            while inpt != 'x':
                inpt = input("==> ")
                if inpt == 'class-filled':
                    self.handle_class_filled()
                elif inpt == 'class-empty':
                    self.handle_class_empty()
                elif inpt == 'throw-filled':
                    self.handle_throw_filled()
                elif inpt == 'throw-empty':
                    self.handle_throw_empty()
                elif inpt == 'sequence-filled':
                    self.handle_sequence_filled()
                elif inpt == 'sequence-one':
                    self.handle_sequence_one()
                elif inpt == 'sequence-empty':
                    self.handle_sequence_empty()
                elif inpt == 'void-method':
                    self.handle_void_method()
                elif inpt == 'optional-params-filled':
                    self.handle_optional_params_filled()
                elif inpt == 'optional-params-empty':
                    self.handle_optional_params_empty()
                elif inpt == 'all':
                    self.handle_all()
                elif inpt == 'x' or inpt == '':
                    pass
                else:
                    print("???")
        except Exception as e:
            print(e)
        finally:
            self.shutdown()
            sys.exit(self.status)


if __name__ == "__main__":
    client = IceClient()
    client.main()
