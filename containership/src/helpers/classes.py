#!/usr/bin/env python3
from dataclasses import dataclass


class Stauplan:
    def __init__(self, ship):
        self.ship = ship

    def __repr__(self):
        print(f'{type(self).__name__}')
        for row in range(len(self.ship.bay)):
            print(f'Row: {row}')
            for tier in range(len(self.ship.bay[row])):
                print(f'\tTier: {tier}')
                for container in self.ship.bay[row][tier]:
                    print(f'\t\tContainer: {container.number} with weight: {container.weight}')


@dataclass
class Container:
    id: int
    weight: int


@dataclass
class Tier:
    id: int
    used: bool
    data: Container


@dataclass
class Row:
    id: int
    weight: int
    tiers: list


@dataclass
class Bay:
    rows: list
    weight: int


class NRowsNTiersShip:
    def __init__(self, rows: int, tiers: int):
        self.rows: int = rows
        self.tiers: int = tiers

        self.bay: Bay = Bay(
            rows=[
                Row(
                    id=row,
                    tiers=[
                        Tier(
                            id=tier,
                            used=False,
                            data=Container(
                                id=0,
                                weight=0
                            )
                        ) for tier in range(self.tiers)
                    ]
                ) for row in range(self.rows)
            ]
        )

    def __repr__(self):
        result: list = []
        for row in self.bay.rows:
            for tier in row.tiers:
                result.append('2%d ' % tier.data.id)
            result.append('\n')
        return ''.join(result)

    def _get_next_position_(self):
        summed_rows: list = []
        for row in self.bay.rows:
            summed_rows[row]: int = 0


            # calculate the min index from the tier list
            summed_tiers: list = []
            for tier in row.tiers:
                summed_rows[row] += tier.weight
                summed_tiers.append(tier.weght)

            min_tier: int = summed_tiers.index(min(summed_tiers))

        min_row: int = min(summed_rows.index(min(summed_rows)))



        #min_row, tier_list = min(enumerate(self.bay), key=lambda x: sum(y.weight for y in x[1]))
        #mintier = min(range(len(tier_list)), key=lambda x: tier_list[x].weight)
        #return min_row, mintier

    def insert(self, data: list):
        for container_list in data:
            min_row, min_tier = self._get_next_position_()
            self.bay[min_row][min_tier]: Container = Container(*container_list)