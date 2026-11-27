import type { Application } from './applicationDto'

export async function getApplications(): Promise<Application[]> {
  const response = await fetch('/api/applications')
  if (!response.ok) {
    throw new Error(`Failed to fetch applications (${response.status})`)
  }
  return response.json() as Promise<Application[]>
}
