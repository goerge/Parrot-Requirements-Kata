<?php

namespace Tests;

use Parrot\Parrot;
use Parrot\ParrotTypeEnum;
use PHPUnit\Framework\TestCase;

class ParrotTest extends TestCase
{

    /** @test */
    public function foo()
    {
        $parrot = new Parrot(ParrotTypeEnum::EUROPEAN, 0, 0, false);
        $this->assertEquals(0.0, $parrot->getSpeed());
    }

}
