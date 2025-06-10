import { SidebarProvider, SidebarTrigger } from "@/components/ui/sidebar"
import { AppSidebar } from "./app-sidebar"
import { Outlet } from "react-router-dom"

export default function Layout() {
  return (
    <SidebarProvider className="w-screen">
      
      <AppSidebar />
      <main className="w-dvw"> {/* makes auto-sized main area content */}
        <SidebarTrigger className=" scale-100"/>
         <Outlet  /> {/* This renders the nested route components like Home or Info */}
      
      </main>
    
    </SidebarProvider>
  )
}