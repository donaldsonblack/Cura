import "../index.css"
import { twMerge } from "tailwind-merge"
import { ArrowRight, Cross, GlobeLock, MapPin, Salad, TrendingUp} from "lucide-react"
import type { ReactNode } from "react"
import { ChartContainer, ChartTooltip, ChartTooltipContent, type ChartConfig } from "@/components/ui/chart"
import { Bar, BarChart, CartesianGrid, XAxis } from "recharts"
import { Card, CardContent, CardFooter, CardHeader, CardTitle, CardDescription } from "@/components/ui/card"
import {
  Carousel,
  CarouselContent,
  CarouselItem,
  CarouselNext,
  CarouselPrevious,
} from "@/components/ui/carousel"
import { Skeleton } from "@/components/ui/skeleton"

function Info() {
    return (
        <>
        

        <div className='min-h-screen bg-white px-4 py-12 text-zinc-900'>
            <div className=" mx-auto max-w-12xl grid grid-cols-12 gap-4">
                <HeaderBlock></HeaderBlock>
                <SocialsBlock></SocialsBlock>
                <AboutBlock></AboutBlock>
                <LocationBlock></LocationBlock>
                <Block className="col-span-3 row-span-1 m-0 p-0"><Skeleton className=" rounded-full" /></Block>
               <Block className="col-span-6 row-span-2 m-0 p-0"><Skeleton className=" rounded-full" /></Block> 
                <CarouselBlock></CarouselBlock>
                <Block className="col-span-6 row-span-2 m-0 p-0"><Skeleton className=" rounded-full" /></Block>
            </div>
        </div>


            
        </>
    )
}

export default Info

// UNDERSTAND WHAT IS GOING ON BELOW

type Props = { // what is type? what is a prop?
    className?: string;   // why do i need this line?
    children?: ReactNode;  // is ? for optional? what is a react node? 
};

const Block = ({ children, className, ...rest } : Props)  => { // what is this doing? is it a for each? is it defining each as a prop?
    return (
        <div className={twMerge("col-span-4 rounded-lg border border-zinc-200 bg-zinc-100 p-6", className )} {...rest}>{children}
</div>
    );
};

const HeaderBlock = () => {
    return ( <Block className="col-span-12 row-span-2 md:col-span-6 ">
        <img src="https://healthicons.org/icons/svg/outline/places/hospital.svg" alt="avatar" className="mb-4 size-14  bg-none" />
        <h1 className="mb-12 text-4xl leading-tight font-bold" >Medical Maintenance <span className="text-zinc-400 font-medium">Secure Health  Software</span></h1>
        
        <a href="#" className="flex group items-center gap-1 text-red-600 hover:underline hover:font-medium ">Inquire Now <ArrowRight className="size-4 transition-transform duration-300 ease-in-out group-hover:-rotate-45 group-hover:scale-130 group-hover:translate-x-1"/> </a> {/* can replace with Link from router to not refresh page */}
        
    </Block>
    )
}

const SocialsBlock = () => (
    <>
        <Block className="col-span-6 bg-red-500 md:col-span-3 hover:scale-105 hover:rotate-3 transition-transform duration-200 ease-in-out">
            <a href="" className="grid h-full place-content-center text-3xl text-white">
                <Cross />
            </a>
        </Block>
        <Block className="col-span-6 bg-green-500 md:col-span-3 hover:scale-105 hover:-rotate-3 transition-transform duration-200 ease-in-out">
            <a href="" className="grid h-full place-content-center text-3xl text-white">
                <Salad />
            </a>
        </Block>
        <Block className="col-span-6 bg-blue-500 md:col-span-3 hover:scale-105 hover:rotate-3 transition-transform duration-200 ease-in-out">
            <a href="" className="grid h-full place-content-center text-3xl text-white">
                <GlobeLock />
            </a>
        </Block>
        <Block className="col-span-6 bg-zinc-50 md:col-span-3 hover:scale-105 hover:-rotate-3 transition-transform duration-200 ease-in-out">
            <a href="" className="grid h-full place-content-center text-3xl text-white">
                <Cross />
            </a>
        </Block>
    </>
)

const AboutBlock = () => (
    <Block className="col-span-12 text-3xl leading-snug ">
        <p className=" font-bold">
            This is for Hospitals. {" "}
            <span className="text-zinc-400 font-medium">
                This was made with AWS, React, Java, Tailwind,
                and more.
            </span>
        </p>
    </Block>
)

const LocationBlock = () => (
    <Block className="col-span-12 flex flex-col items-center gap-4 md:col-span-3">
        <MapPin className="text-3xl"/>
        <p className="text-center text-lg text-zinc-900 font-bold ">Melbourne, VIC</p>
    </Block>
)


const CarouselBlock = () => (
        <Block className="col-span-6 p-0 row-span-3 md:col-span-6 bg-white border-white">
            
                <Carousel className="border-none">
        <CarouselContent className="border-none">
            {Array.from({ length: 5 }).map((_, index) => (
            <CarouselItem key={index} className="border-none">
                <div className="p-1 border-none">
                <Card className="border-zinc-300 ">
                    <CardContent className="flex aspect-square items-center justify-center p-6">
                    <span className="text-4xl font-semibold border-zinc-300 ">{index + 1}</span>
                    </CardContent>
                </Card>
                </div>
            </CarouselItem>
            ))}
        </CarouselContent>
        <CarouselPrevious className=" border-none translate-x-15" />
        <CarouselNext className="border-none -translate-x-15" />
        </Carousel>
    
    </Block>
)

