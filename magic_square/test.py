#!/usr/bin/env python3
from run import MagicSquare


def test(start: int, end: int, step: float = 1):
    result: dict = {
        'failure': [],
        'success': []
    }

    for i in range(start, end, step):
        start_message: str = f'Testing magic square generation for value: {i}'
        print(start_message)
        print(''.join('-' for _ in range(len(start_message))))

        try:
            ms = MagicSquare(n=i)
            ms.gen()
            print(ms)
            stop_message: str = f'Success for value: {i}'
            result['success'].append(i)
        except BaseException:
            stop_message: str = f'Failed for value: {i}'
            result['failure'].append(i)
        finally:
            print(''.join('-' for _ in range(len(stop_message))))
            print(stop_message)
            print('\n\n')

    print(
        'The tests succeeded for the following values: %s' %
        result['success'])
    print('The tests failed for the following values: %s' % result['failure'])


if __name__ == '__main__':
    test(
        start=3,
        end=30,
    )
